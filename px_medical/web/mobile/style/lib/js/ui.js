// 左侧菜单收缩展开
var status = 1;
function switchSysBar(){
    var switchPoint=document.getElementById("switchPoint");
    var frmTitle=document.getElementById("frmTitle");
    var frmMain=document.getElementById("frmMain");
    if (1 == window.status){
        window.status = 0;
        //alert(switchPoint);

        frmTitle.classList.add("show");
        frmMain.classList.add("show")
    }
    else{
        window.status = 1;
        frmTitle.classList.remove("show");
        frmMain.classList.remove("show")
    }
}
