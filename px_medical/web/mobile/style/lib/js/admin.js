var status = 1;

function switchSysBar(){
	var switchPoint=document.getElementById("switchPoint");
	var frmTitle=document.getElementById("frmTitle");
     if (1 == window.status){
		  window.status = 0;
		  //alert(switchPoint);

          //switchPoint.style.backgroundImage = 'url(images/left.gif)';
          frmTitle.style.width="1.2rem"
     }
     else{
		  window.status = 1;
          //switchPoint.style.backgroundImage = 'url(images/right.gif)';
          frmTitle.style.width=".6rem"
     }
}

