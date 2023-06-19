const form = document.getElementById('labOrderForm');
const submitBtn = document.querySelector('input[type="submit"]');

submitBtn.addEventListener('click', function (event) {
    event.preventDefault();

    const studyName = document.getElementById('studyName').value;
    const studyReason = document.getElementById('studyReason').value;
    const precautionTreatment = document.getElementById('precautionTreatment').value;

    if (!studyName) {
        swal({
            title: 'Error',
            text: 'Ingresa el nombre del estudio.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (!studyReason) {
        swal({
            title: 'Error',
            text: 'Ingresa la razón por la que se solicita el estudio.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    const studyReasonLength = studyReason.replace(/\s/g, '').length;
    if (studyReasonLength < 5 || studyReasonLength > 255) {
        swal({
            title: 'Error',
            text: 'La razón por la que se solicita el estudio debe tener al menos 5 letras y no exceder las 255 letras.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }
    if (studyName.length < 5 || studyName.length > 255) {
        swal({
            title: 'Error',
            text: 'El nombre de el estudio debe tener al menos 5 letras y no exceder las 255 letras.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (!precautionTreatment) {
        swal({
            title: 'Error',
            text: 'Ingresa el tratamiento mientras tanto.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (precautionTreatment.length < 5 || precautionTreatment.length > 255) {
        swal({
            title: 'Error',
            text: 'El tratamiento mientras tanto debe tener al menos 5 letras y no exceder las 255 letras.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    form.submit();
});
