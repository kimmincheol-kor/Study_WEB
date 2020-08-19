var fs = require('fs');

fs.writeFile(`created_data/wrote_data`, 'hi hi !', 'utf8', function(err) {
  console.log('hi');
});
