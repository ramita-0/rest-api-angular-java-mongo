$.ajax({
    url: "http://localhost:8080/api/venta",
    type: 'GET'
})
.done(function (data) {

/* hace algo con el objeto "data" recibido, si es que recibe algo */

console.log(data);

})
.fail(function (jqXHR, textStatus, errorThrown) {
console.log("error, no se pudo obtener datos");
console.log(jqXHR);
console.log(textStatus);
console.log(errorThrown);
});
