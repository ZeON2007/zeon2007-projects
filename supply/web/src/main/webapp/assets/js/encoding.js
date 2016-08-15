var $ = function(id) {
    return document.getElementById(id);
};
var encode = function () {
    $('search').value = encodeURIComponent($('search').value);
};
