require('isomorphic-fetch');
const scalajs = require("./scalajsDist/front-fastopt");

console.log(scalajs);
console.log(scalajs.ExportToJS().func1());

scalajs.ExportToJS().fetch2("http://localhost:3000")
  .then(v => console.log(v));