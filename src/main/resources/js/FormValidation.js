/**
 * Created by darle on 6/29/2017.
 */

$.mask.definitions['1'] = "[0-3]";
$.mask.definitions['2'] = "[0-9]";
$.mask.definitions['3'] = "[0-1]";
$.mask.definitions['4'] = "[0-9]";

$('#fechanac').mask('12/34/9999');


var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; //January is 0!
var yyyy = today.getFullYear();

if(dd<10) {
    dd = '0'+dd
}

if(mm<10) {
    mm = '0'+mm
}

today = mm + '/' + dd + '/' + yyyy;

function myFunction() {
   var x;

    // Get the value of the input field with id="numb"
    x = document.getElementById("fechanac").value;

    // If x is Not a Number or less than one or greater than 10
    if (x > today) {
        text = "Fecha no válida";
    }

    document.getElementById("demo").innerHTML = text;
}
