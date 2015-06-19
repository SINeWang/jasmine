function loadUser() {
    beforeAction("Loading...");
    $.ajax({
        type: 'GET',
        url: '/user',
        success: function (data) {
            var ret = eval(data);
            if (ret.c == 0) {
                var v = ret.d + "@sinewang.com";
                $("#navbar-brand").html(v);
            } else {
                alert(ret.m);
            }
        },
        error: function (data) {
            alert(data);
        },
        complete: function (data) {
            afterAction();
        },
        dataType: 'json'
    });
}