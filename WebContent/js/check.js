function change(img){
	img.src="getCode?"+new Date().getTime();
}

function FocusItem(obj){
	if($(obj).attr('name')=='code'){
		$(obj).next().next().html('').removeClass('error');
	}else{
		$(obj).next('span').html('').removeClass('error');
	}
	
}

var flag=true; //标记位

function CheckItem(obj){
	var msgBox=$(obj).next('span');
	switch($(obj).attr('name')){
		case "userName":
			if(obj.value==""||obj.value==null){
				msgBox.html('用户名不能为空');
				msgBox.addClass('error');
				flag=false;
			}else{
				var url="UsernameCheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();
				
				//
				$.get(url,function(data){
					if(data=="false"){
						msgBox.html('用户名不能使用！');
						msgBox.addClass('error');
						flag=false;
					}else{
						msgBox.html().removeClass('error');
						flag=true;
					}
				});
			}
			break;
		case "password":
			if(obj.value==""||obj.value==null){
				msgBox.html('密码不能为空');
				msgBox.addClass('error');
				flag=false;
			}else{
				flag=true;
			}
			break;
		case "rePassword":
			if(obj.value==""||obj.value==null){
				msgBox.html('确认密码不能为空');
				msgBox.addClass('error');
				flag=false;
			}else if($(obj).val()!=$('input[name="password"]').val()){
				msgBox.html('两次输入的密码不一致');
				msgBox.addClass('error');
				flag=false;
			}else{
				flag=true;
			}
			break;
		case "code":
			var code=$(obj).next().next();
			if(obj.value==""||obj.value==null){
				code.html('验证码不能为空');
				code.addClass('error');
				flag=false;
			}else{
				
				var url="CheckCode?code="+encodeURI($(obj).val())+"&"+new Date().getTime();
				$.get(url,function(num){
					if(num=="false"){
						code.html('验证码输入错误');
						code.addClass('error');
						flag=false;
					}else{
						code.html().removeClass('error');
						flag=true;
					}
					
				});
			}
			break;
	}
}

function checkForm(frm){
	var els=frm.getElementsByTagName('input');
	
	//onblur这个属性才是需要验证
	
	for(var i=0;i<els.length;i++){
		if(els[i]!=null){
			if(els[i].getAttribute("onblur")){
				CheckItem(els[i]);
			}
		}
	}
	return flag;
}
