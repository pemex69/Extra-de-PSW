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

    vetLoginForm.submit();
});
