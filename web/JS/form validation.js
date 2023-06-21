document.getElementById('clients').addEventListener('submit', function (event) {
    event.preventDefault();

    let nameInput = document.getElementById('clientName');
    let emailInput = document.getElementById('clientEmail');
    let clientPass = document.getElementById('clientPass');

    let name = nameInput.value; 
    let email = emailInput.value;
    let pass = clientPass.value; 

    let emailRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    if (name === '') {
        swal('Por favor, ingresa tu nombre.');
        nameInput.focus();
        return;
    }
    if (name.length < 3) {
        swal('Por favor, ingresa un nombre de más de 3 caracteres.');
        nameInput.focus();
        return;
    }

    if (email === '') {
        swal('Por favor, ingresa tu correo electrónico.');
        emailInput.focus();
        return;
    }
    if (email.length < 3) {
        swal('Por favor, ingresa un correo electrónico de más de 3 caracteres.');
        emailInput.focus();
        return;
    }
    if (!emailRegex.test(email)) {
        swal('Por favor, ingresa un correo electrónico válido.');
        emailInput.focus();
        return;
    }
    if (pass === '') {
        swal('Por favor, ingresa tu contraseña.');
        clientPass.focus();
        return;
    }
    if (pass.length < 3) {
        swal('Por favor, ingresa una contraseña de más de 3 caracteres.');
        clientPass.focus();
        return;
    }
    event.target.submit();
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