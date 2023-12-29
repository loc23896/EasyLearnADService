function checkNull1(){
    let userName = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    if (userName === ''|| password === '') {
        alert("Vui lòng điền đầy đủ thông tin");
        return false;
    }
}