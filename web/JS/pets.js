const form = document.querySelector('form[action="PetServlet"]');
const messageArea = document.getElementById('registerMessageArea');
const registerBtn = document.querySelector('input[type="submit"]');

registerBtn.addEventListener('click', function (event) {
    event.preventDefault();

    const petName = document.getElementById('petName').value;
    const petSpecies = document.getElementById('petSpecies').value;
    const petRace = document.getElementById('petRace').value;
    const petWeight = document.getElementById('petWeight').value;
    const petHealthState = document.getElementById('petHealthState').value;

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
            text: 'El nombre de la mascota solo puede contener letras y números.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (petSpecies.length < 3 || petSpecies.length > 50) {
        swal({
            title: 'Error',
            text: 'La especie de la mascota debe tener entre 3 y 50 caracteres.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }
    if (!isSafeInput(petSpecies)) {
        swal({
            title: 'Error',
            text: 'La especie de la mascota solo puede contener letras y números.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (petRace.length < 3 || petRace.length > 50) {
        swal({
            title: 'Error',
            text: 'La raza de la mascota debe tener entre 3 y 50 caracteres.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }
    if (!isSafeInput(petRace)) {
        swal({
            title: 'Error',
            text: 'La raza de la mascota solo puede contener letras y números.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (petWeight > 10000) {
        swal({
            title: 'Error',
            text: 'El peso de la mascota es excesivo',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (!isSafeInput(petWeight)) {
        swal({
            title: 'Error',
            text: 'El peso de la mascota solo puede contener números.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (isNaN(parseFloat(petWeight)) || parseFloat(petWeight) <= 0) {
        swal({
            title: 'Error',
            text: 'El peso de la mascota debe ser un número positivo.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }

    if (petHealthState.length < 3 || petHealthState.length > 100) {
        swal({
            title: 'Error',
            text: 'El estado de salud de la mascota debe tener entre 3 y 100 caracteres.',
            icon: 'error',
            button: 'Aceptar',
        });
        return;
    }
    if (!isSafeInput(petHealthState)) {
        swal({
            title: 'Error',
            text: 'El estado de salud de la mascota solo puede contener letras y números.',
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