// JavaScript Document
function settab(i)
{
	switch(i)
		{
			case 1:
				document.getElementById("bg").className="bg1";
				document.getElementById("title1").style.color="#f8f8f8";
				document.getElementById("title2").style.color="#000000";
				document.getElementById("contant1").style.display="block";
				document.getElementById("contant2").style.display="none";
			break;
			case 2:
				document.getElementById("bg").className="bg2";
				document.getElementById("title1").style.color="#000000";
				document.getElementById("title2").style.color="#f8f8f8";
				document.getElementById("contant1").style.display="none";
				document.getElementById("contant2").style.display="block";
			break;
		}
}