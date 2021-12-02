//demo inputs

var Classes = [{
        'Name': 'CSCI-1100'
    },
    {
        'Name': 'BIOL-2120'
    },
    {
        'Name': 'CSCI-4440'
    }
];

var Clubs = [{
        'Name': 'RPI-TV'
    },
    {
        'Name': 'Curling'
    }
];


function addClass() {
    //CREATE dummy new class
    var newClass = `<p class="class">
    <font color="#6CA0DC"
      ><i class="fas fa-university fa-lg"></i
    ></font>
    &nbsp;
    <h8 class="pageLink" contenteditable = "true">New Class </h8>
  </p>`;

    //insert before classAdd
    $(newClass).insertBefore($("#classAdd"));
};


function addClub() {
    //CREATE dummy new class
    var newClass = `<p class="class">
    <font color="#6CA0DC"
      ><i class="fas fa-university fa-lg"></i
    ></font>
    &nbsp;
    <h8 class="pageLink" contenteditable = "true">New Club </h8>
  </p>`;

    //insert before clubAdd
    $(newClass).insertBefore($("#clubAdd"));
};