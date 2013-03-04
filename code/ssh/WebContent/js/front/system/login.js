/*登陆操作*/
function login()
{
	$.ajax({
		type: 'POST',
		url: 'front/login.htm',
		data: $("#loginForm").serialize(),
		success:function(data)
		{
			if(data.errorMsg == 'success')
			{
				location.href="front/index.htm";
			}
			else
			{
				$("#errorMsg").html(data.errorMsg);
			}
			
		},
		error:function()
		{
			$("#errorMsg").html("服务器发生异常");
		}
	});
	return false;
}