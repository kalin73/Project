function checkPassword() {

    let password = document.getElementById("password").value;
    let cnfrmPassword = document.getElementById("confirm-password").value;
    let message = document.getElementById("message");

    if (password.length != 0) {
        if (password == cnfrmPassword) {
            message.textContent = "Passwords match";
            message.style.backgroundColor = '#3AE374';
        }
        else {
            message.textContent = "Password don't match";
            message.style.backgroundColor = '#FF4D4D';
        }
    }
    else {
        alert("Password can't be empry!");
        message.textContent = "";
    }
}