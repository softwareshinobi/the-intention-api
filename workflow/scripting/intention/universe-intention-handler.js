$(document).ready(function () {

//alert("yo");

    $("#intention").val("--");

    getUniverseIntention();

});

function getUniverseIntention() {

    console.debug("enter -> getUniverseIntention");

//////////////////////////////////////////

    $.ajax({

        type: "GET",

        url: upstreamAPIURL + "",

        crossDomain: true,

        dataType: "text",

        success: function (response, status, jqXHR) {

//alert("success");

            console.log("response / " + response);

            intention = response;

            console.log("intention / server / " + intention);

            $("#intention").val(intention);

        },

        error: function (exception, status) {
//alert("error");
            console.log("error issuing request");

            console.log("status / " + status);

            console.log("exception / " + exception);

        }

    });

}

function processForm() {

    console.debug("enter -> processForm");

    intention = $("#intention").val();

    //alert("intention / " + intention);

//////////////////////////////////////////

    payload = JSON.stringify({

        intention: intention,

    });

    //alert("payload / ", payload);

//////////////////////////////////////////

    $.ajax({

        type: "POST",

        url: upstreamAPIURL + "",

        data: payload,

        contentType: "application/json; charset=utf-8",

        crossDomain: true,

        dataType: "text",

        success: function (response, status, jqXHR) {

            console.log("response / " + response);

            //      alert(response);

            getUniverseIntention();

        },

        error: function (exception, status) {

            alert("problem");

            console.log("error issuing request");

            console.log("status / " + status);

            console.log("exception / " + exception);

        }

    });

}
