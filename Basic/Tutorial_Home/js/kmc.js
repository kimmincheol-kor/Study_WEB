function kmc_makeContent(name) {
  document.getElementById("main_content").innerHTML = "<h2 class=\"w3-text-light-grey\">" + name + "</h2> <hr style=\"width:200px\" class=\"w3-opacity\"><p>구현중</p>";
}

// function readTextFile(file) {
//   var rawFile = new XMLHttpRequest();
//   rawFile.open("GET", file, false);
//   rawFile.onreadystatechange = function () {
//     if(rawFile.readyState === 4) {
//       if(rawFile.status === 200 || rawFile.status == 0) {
//         var allText = rawFile.responseText;
//         alert(allText);
//       }
//     }
//   };
//   rawFile.send(null);
// }
//
// readTextFile("file:///C:/Users/KMC_Vivo/Desktop/web/Tutorial_Home/content_about.txt");
