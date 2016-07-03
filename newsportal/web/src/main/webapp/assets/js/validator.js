function validate(form_id,email) {
    var reg = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    var address = document.forms[form_id].elements[email].value;
    $("#result").text("");
    if(reg.test(address) == false) {
        $("#result").text("You have entered an invalid email address");
        $("#result").css("color", "red");        
        return false;
    }
}

