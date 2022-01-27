function validateForm(){
 var form = document.simpleForm;
    var uname = form.un;
    var pwd = form.pwd;
    if(uname.value.length < 1){
         alert("Username cannot be empty");
         document.write("Seema")
        return false;
    }
    if(pwd.value.length < 1){
        alert("Password cannot be empty");
        return false;
    }
    //return true;
}