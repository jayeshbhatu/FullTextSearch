/**
 * 
 */

function callMsg(message)
    {
    	alert(message);
    }
    
function checkNumber(temp)
{
	var re = /^([0-9])+$/;
	if(re.test(temp))
	{
		return true;
	}
	else
	{
		return false;	
	}
}
function checkAlphabetic(temp)
{
	var re = /^([a-zA-Z])+$/;
	if(re.test(temp))
	{
		return true;
	}
	else
	{
		return false;	
	}
}
function checkPassword(temp)
{
	var re = /^\S*$/;;
	if(re.test(temp))
	{
		return true;
	}
	else
	{
		return false;	
	}
}
function checkEmail()
{
	var email = document.getElementsByName('Email')[0].value; 
	
 		var re =  /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9]+\.([a-zA-Z]{2,10}|[a-zA-z]{2,10}\.[a-zA-Z]{2,10})$/;
 		
 		if(re.test(email))
 		{
 			return true;	
 		}
 		else
 		{
 			return false;
 		}
 			
}

