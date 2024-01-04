function checkNull(){
    let firstName = document.getElementById("firstName").value;
    let lastname = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;
    let address = document.getElementById("address").value;
    let phone = document.getElementById("phone").value;
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let managementType = document.getElementById("managementType").value;
    if (firstName === '' || lastname === '' || email === '' || address === ''|| phone === '' || username === ''|| password === '') {
        alert("Vui lòng điền đầy đủ thông tin");
        return false;
    }
    if(phone.length !== 10){
        alert("Số điện thoại chưa đúng định dạng 10 số");
        return false;
    }
    if(managementType === "-1"){
        alert("Vui lòng chọn Management Type")
        return false;
    }
}