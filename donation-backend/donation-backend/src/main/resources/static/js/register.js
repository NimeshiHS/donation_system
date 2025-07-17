document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('registerForm');

  form.addEventListener('submit', async function (event) {
    event.preventDefault();

    const formData = {
      name : document.getElementById('name').value,
      email: document.getElementById('email').value,
      password: document.getElementById('password').value,
      role: document.getElementById('role').value,
    };

    try {
      const response = await fetch('http://localhost:8080/api/register', {
        method: 'POST',

        body: formData
      });

      if (response.ok) {
        alert('Registration successful!');
        window.location.href = 'index.html'; //  Redirect
      } else {
        const errorText = await response.text();
        alert('Registration failed: ' + errorText);
      }
    } catch (error) {
      console.error('Error:', error);
      alert('Could not connect to server.');
    }
  });
});
