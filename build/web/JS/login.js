const loginForm = document.getElementById('loginForm');
const messageArea = document.getElementById('messageArea');
const loginBtn = document.getElementById('loginbtn');

loginBtn.addEventListener('click', function (event) {
    event.preventDefault();

    const email = document.getElementById('clientEmail').value;
    const password = document.getElementById('clientPass').value;

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
            text: 'La contraseña solo puede contener letras, números y los siguientes caracteres: !@#$%^&*()_+',
            icon: 'error',
            button: 'Aceptar',

        });
        return;
    }


    loginForm.submit();
});

const vetLoginForm = document.getElementById('vetLoginForm');
const vetloginbtn = document.getElementById('vetloginbtn');

vetloginbtn.addEventListener('click', function (event) {
    event.preventDefault();

    const email = document.getElementById('vetEmail').value;
    const password = document.getElementById('vetPass').value;

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
            text: 'La contraseña solo puede contener letras, números y los siguientes caracteres: !@#$%^&*()_+',
            icon: 'error',
            button: 'Aceptar',

        });
        return;
    }

    vetLoginForm.submit();
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