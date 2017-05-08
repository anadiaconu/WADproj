function validateForm()
{
    var ok = true;
    ok = ok && validateName() && validateUname() && validatePass() && validateEmail();
    return ok;
    
}
function validateName()
{
    var text = document.getElementById("name").value;
    if(text.length === 0)
    {
        document.getElementById("ename").style.display="inline";
        return false;
    }
    for(var i=0;i<text.length;++i)
    {
        var c = text.charAt(i);
        if((c<'A'||(c>'Z'&&c<'a')||c>'z')&&c!=' '&&c!='\'')
        {
            document.getElementById("ename").style.display="inline";
            return false;
        }
    }
    
    document.getElementById("ename").style.display="none";
    return true;
}

function validateUname()
{
    var text = document.getElementById("username").value;
    if(text.length === 0)
    {
        document.getElementById("eusername").style.display="inline";
        return false;
    }
    for(var i=0;i<text.length;++i)
    {
        var c = text.charAt(i);
        if((c<'A'||(c>'Z'&&c<'a')||c>'z')&&(c!=='_'&&c!=='.'&&(c<'0'||c>'9')))
        {
            document.getElementById("eusername").style.display="inline";
            return false;
        }
    }
    
    document.getElementById("eusername").style.display="none";
    return true;
}
function validatePass()
{
    var text = document.getElementById("password").value;
    var l = text.length;
    var text2 = document.getElementById("repassword").value;
    if(l<8 || l>20)
    {
        document.getElementById("epassword").style.display="inline";
         document.getElementById("erepassword").style.display="none";
        return false;
    }
    else
    {
         document.getElementById("epassword").style.display="none";
         document.getElementById("erepassword").style.display="none";
    }
    if(text!==text2)
    
    {
        document.getElementById("erepassword").style.display="inline";
        return false;
    }
    else
    {
         document.getElementById("erepassword").style.display="none";
    }
    return true;
}