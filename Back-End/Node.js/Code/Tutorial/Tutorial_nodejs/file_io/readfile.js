var fs = require('fs'); // use module 'file system'

// https://nodejs.org/dist/latest-v6.x/docs/api/fs.html#fs_fs_read_fd_buffer_offset_length_position_callback
fs.readFile('sample.txt', 'utf8', function(err, data){
  console.log(data);
});
