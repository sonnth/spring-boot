const eurekaHelper = require('./eureka-helper');
var express = require('express');

var router = express.Router();
/* GET home page. */

router.get('/users', function(req, res, next) {
  res.send('user-service from port' + (process.env.PORT || '3000'));
});
module.exports = router;

eurekaHelper.registerWithEureka('user-service', 3000);
