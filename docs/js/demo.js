//demo inputs

var events = [{
    'Date': new Date(2021, 10, 11),
    'Title': 'SDD Demo',
    'Link': 'index.html'
  },
  {
    'Date': new Date(2021, 10, 12),
    'Title': 'SDD Beta Release',
    'Link': 'https://docs.google.com/document/d/1aDV_G4XrcJIoWNtrpYsaJop_2_M69id6TD-jsQlJtSA'
  },
  {
    'Date': new Date(2021, 10, 27),
    'Title': 'Exam',
    'Link': 'csci-4440.html'
  },
];
var settings = {};
var element = document.getElementById('caleandar');
caleandar(element, events, settings);

$(function () {
  function addEvent() {
    var tempElement = {
      'Date': new Date(2021, 10, 22),
      'Title': 'SDD Beta Demo',
      'Link': 'index.html'
    };
    events.push(tempElement);
    $("#caleandar").empty();
    caleandar(element, events, settings);
  }
  addEvent();


  $('#newEvent').submit(function (event) {

    var tempNew = $('#newEvent').serializeArray();

    var tempElement = {
      'Date': new Date(tempNew[2].value, tempNew[3].value - 1, tempNew[4].value),
      'Title': tempNew[0].value,
      'Link': tempNew[1].value
    };
    events.push(tempElement);
    $("#caleandar").empty();
    caleandar(element, events, settings);

    $('#nname').val('');
    $('#nlink').val('');
    $('#ndate').val(2);
    event.preventDefault();
  });
});