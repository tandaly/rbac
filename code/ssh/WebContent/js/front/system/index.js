
/*发表心情*/
function publishMood()
{
	var publishContent = $("#publishContent");
	if("" ==  $.trim(publishContent.val()))
	{
		alert("请输入内容");
		publishContent.val(" ");
		publishContent.focus();
		return false;
	}
	return true;
}