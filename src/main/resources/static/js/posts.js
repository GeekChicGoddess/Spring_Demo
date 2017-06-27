/**
 * Created by melodytempleton on 6/27/17.
 */
(function ($) {
    var isLastPage = false;
    var currentPage = 1;
    var fetching = false;


$(window).scroll(function () {
    if ($(window).scrollTop() >= $(document).height() - $(window).height() - 30) {

        if (isLastPage || fetching) {
            return; // either there are no more pages, or we're already fetching the next page
        }

        fetching = true;


        var request = $.ajax({
            url: "/posts.json",
            data: {page: currentPage}
        });
        request.done(function (page) {
            var html = "", i;
// page is the JSON response produce by our controller
            var posts = page.content;
// $posts is the div element where we want to add the next page of posts
            var $posts = $("[data-posts]");
// The response already has the information to determine if this is the last page
            isLastPage = page.last;

            for (i = 0; i < posts.length; i++) {
                html += "<div><h1>" + posts[i].title + "</h1><p>" + posts[i].body + "</p></div>";
            }

            $posts.append(html);
            currentPage++;  // move to the page after this one
            fetching = false;
        });
    }
});
})(jQuery);