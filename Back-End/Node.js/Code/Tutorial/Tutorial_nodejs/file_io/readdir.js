var dataFolder = '../../data';
var fs = require('fs');

fs.readdir(dataFolder, function(err, datalist){
  console.log(datalist);
});
