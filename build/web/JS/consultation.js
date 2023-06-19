const form = document.querySelector('form[action="saveConsultation"]');
const submitBtn = document.querySelector('button[type="submit"]');

submitBtn.addEventListener('click', function (event) {
    event.preventDefault();

    const petId = document.getElementById('petId').value;
    const vetId = document.getElementById('vetId').value;
    const consultationDate = document.getElementById('consultationDate').value;
    const consultationNotes = document.getElementById('consultationNotes').value;
    const consultationTreatment = document.getElementById('consultationTreatment').value;

    if (!petId) {
        swal({
            title: 'Error',
            text: 'Selecciona un ID válido para la mascota.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (!vetId) {
        swal({
            title: 'Error',
            text: 'Selecciona un veterinario válido.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (!consultationDate) {
        swal({
            title: 'Error',
            text: 'Selecciona una fecha válida para la consulta.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (!consultationNotes) {
        swal({
            title: 'Error',
            text: 'Ingresa las notas de la consulta.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (consultationNotes.length > 255 || consultationNotes.length < 10) {
        swal({
            title: 'Error',
            text: 'Las notas de la consulta deben tener entre 10 y 255 caracteres.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (!consultationTreatment) {
        swal({
            title: 'Error',
            text: 'Ingresa el tratamiento recetado.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (consultationTreatment.length > 255 || consultationTreatment.length < 10) {
        swal({
            title: 'Error',
            text: 'El tratamiento de la consulta debe tener entre 10 y 255 caracteres.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    form.submit();
});
