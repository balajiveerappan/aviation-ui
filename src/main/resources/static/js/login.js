var validateForm =  function () {
        var un = document.loginform.username.value;
        var pw = document.loginform.password.value;
        var username = "username"; 
        var password = "password";
        if ((un == username) && (pw == password)) {
            window.location = "";
            return false;
        }
       
      }