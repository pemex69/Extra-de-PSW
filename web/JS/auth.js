const form = document.getElementById('registrationForm');
const messageArea = document.getElementById('registerMessageArea');
const postUserBtn = document.querySelector('button[type="submit"]');

postUserBtn.addEventListener('click', function (event) {
    event.preventDefault();

    const username = document.getElementById('registerClient').value;
    const email = document.getElementById('registerEmail').value;
    const password = document.getElementById('registerPass').value;

    if (username.length < 3 || username.length > 14) {
        swal({
            title: 'Error',
            text: 'El nombre de usuario debe tener entre 3 y 14 caracteres.',
            icon: 'error',
            button: 'Nimodo',
        });
        return;
    }
    if (!isSafeInput(username)) {
        swal({
            title: 'Error',
            text: 'El nombre de usuario no puede contener caracteres especiales.',
            icon: 'error',
            button: 'Nimodo',
        });
        return;
    }

    const emailRegex = /\S+@\S+\.\S+/;
    if (!emailRegex.test(email)) {
        swal({
            title: 'Error',
            text: 'El email no es válido.',
            icon: 'error',
            button: 'Nimodo',
        });
        return;
    }

    if (!emailisSafeInput(email)) {
        swal({
            title: 'Error',
            text: 'El email no puede contener caracteres especiales.',
            icon: 'error',
            button: 'Nimodo',
        });
        return;
    }

    if (password.length < 3 || password.length > 14) {
        swal({
            title: 'Error',
            text: 'La contraseña debe tener entre 3 y 14 caracteres.',
            icon: 'error',
            button: 'Nimodo',
        });
        return;
    }
    if (!passemaisSafeInput(password)) {
        swal({
            title: 'Error',
            text: 'La contraseña no puede contener ciertos caracteres especiales.',
            icon: 'error',
            button: 'Nimodo',
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