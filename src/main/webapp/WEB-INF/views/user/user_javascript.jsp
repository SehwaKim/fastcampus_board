<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script type="text/javascript">

    function checkId(){
        $.ajax({
            url:'/user/checkid',
            type:'POST',
            data:{id:$('#id').val()},
            success:function(data){
                console.log('data :' + data);
                if(data == 'yes'){
                    $('#id').css('background-color','#ffcece');
                    $('#idhelp').show();
                }else
                {
                    $('#id').css('background-color','#ffffff');
                    $('#idhelp').hide();

                }
            }
        });
    }

    function checkPwd() {
        var pwd = $("#pwd").val();
        var comPwd = $("#pwdCheck").val();

        if(pwd  != comPwd)
        {
            $("#pwdCheck").css('background-color','#ffcece');
            $('#pwdhelp').show();

        }else
        {
            $("#pwdCheck").css('background-color','#ffffff');
            $('#pwdhelp').hide();
        }
    }

    function checkLoginId(){
        $.ajax({
            url:'/user/checkid',
            type:'POST',
            data:{id:$('#loginId').val()},
            success:function(data){
                console.log('data :' + data);
                if(data == 'no'){
                    $('#loginId').css('background-color','#ffcece');
                    $('#loginIdHelp').show();
                }else
                {
                    $('#loginId').css('background-color','#ffffff');
                    $('#loginIdHelp').hide();

                }
            }
        });
    }


    $(document).ready(function(){
        $("#updateBtn").click(function(){
            if(confirm("수정하시겠습니까?")){
                document.forms.action = "${path}/user/update";
                document.forms.submit();
            }
        });
    });

    $(document).ready(function(){
        $("#updatePwdBtn").click(function(){
            if(confirm("수정하시겠습니까?")){
                document.forms.action = "${path}/user/updatePwd";
                document.forms.submit();
            }
        });
    });
</script>

