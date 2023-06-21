const form = document.querySelector('form[action="ScheduleAppointmentServlet"]');
const messageArea = document.getElementById('registerMessageArea');
const scheduleBtn = document.querySelector('button[type="submit"]');

scheduleBtn.addEventListener('click', function (event) {
    event.preventDefault();

    const petName = document.getElementById('other').value;
    const appointmentDate = document.getElementById('start').value;
    const appointmentNotes = document.getElementById('reason').value;

    if (petName.length < 3 || petName.length > 50) {
        swal({
            title: 'Error',
            text: 'El nombre de la mascota debe tener entre 3 y 50 caracteres.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }
    if (!isSafeInput(petName)) {
        swal({
            title: 'Error',
            text: 'El nombre de la mascota no puede contener caracteres especiales.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (!appointmentDate) {
        swal({
            title: 'Error',
            text: 'Selecciona una fecha válida para la cita.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (appointmentNotes.length > 255) {
        swal({
            title: 'Error',
            text: 'La razón de la cita debe tener máximo 255 caracteres.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }
    if (appointmentNotes.length < 10) {
        swal({
            title: 'Error',
            text: 'Poco descriptivo',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }
    if (!isSafeInput(appointmentNotes)) {
        swal({
            title: 'Error',
            text: 'La razón de la cita no puede contener caracteres especiales.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    form.submit();
});

function isSafeInput(input) {
    let sanitizedInput = input.replace(/</g, '&lt;').replace(/>/g, '&gt;');
    return /^[a-zA-Z0-9]+$/.test(sanitizedInput);
}
function emailisSafeInput(input) {
    let sanitizedInput = input.replace(/</g, '&lt;').replace(/>/g, '&gt;');
    return /^[a-zA-Z0-9@.]+$/.test(sanitizedInput);
}
function passemaisSafeInput(input) {
    let sanitizedInput = input.replace(/</g, '&lt;').replace(/>/g, '&gt;');
    return /^[a-zA-Z0-9!@#$%^&*()_+]+$/.test(sanitizedInput);   
}