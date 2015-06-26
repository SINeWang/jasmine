function beforeAction(status) {
    $("#status").html(status);
}

function afterAction() {
    $("#status").html("");
}


function active_nav(module) {
    if (module == null || module == '') {
        module = window.location.href.split("#")[1];
    }
    $('#nav-li > li').each(function (i, l) {
        var li = $(l);
        if (li.attr('id').indexOf(module) > 0) {
            li.removeClass().addClass("active");
        } else {
            li.removeAttr('class');
        }
    })
}