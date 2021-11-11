var events = [
  {'Date': new Date(2021, 10, 11), 'Title': 'SDD Demo'},
  {'Date': new Date(2021, 10, 12), 'Title': 'SDD Beta Release', 'Link': 'https://docs.google.com/document/d/1aDV_G4XrcJIoWNtrpYsaJop_2_M69id6TD-jsQlJtSA'},
  {'Date': new Date(2021, 10, 27), 'Title': 'Exam', 'Link': 'csci-4440.html'},
];
var settings = {};
var element = document.getElementById('caleandar');
caleandar(element, events, settings);
