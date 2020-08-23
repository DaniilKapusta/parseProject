


function tableSS(table) {
table.innerHTML = "";
var ass = {};
var request = new XMLHttpRequest();
request.open('GET', "http://127.0.0.1:8080/GiveData");
request.responseType = 'text';
request.send();
request.onload = function() {
var obj = request.response;
ass = JSON.parse(obj);
alert(ass[1].title);

ass.forEach(s=>  {
var tr = document.createElement('tr');
var td = document.createElement('td');
td.innerHTML=s.title;
tr.appendChild(td);
var td = document.createElement('td');
td.innerHTML=s.author;
tr.appendChild(td);
var td = document.createElement('td');
td.innerHTML=s.link;
tr.appendChild(td);
var td = document.createElement('td');
td.innerHTML=s.stopWord;
tr.appendChild(td);
table.appendChild(tr);
});

}


}
function unvisibleTable(table) {
if (table.hidden == false) {
table.hidden = true;
}
else {
table.hidden = false;
}
}