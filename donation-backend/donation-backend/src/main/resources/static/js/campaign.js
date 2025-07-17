document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('registerForm');

  form.addEventListener('submit', async function (event) {
    event.preventDefault();

    const formData = {
      title : document.getElementById('title').value,
      description: document.getElementById('description').value,
      goal_amount: document.getElementById('goal_amount').value,
      start_date: document.getElementById('start_date').value,
      end_date : document.getElementById('end_date').value,
    };

    try {
      const response = await fetch('http://localhost:8080/api/compaigns', {
        method: 'POST',

        body: formData
      });

      if (response.ok) {
        alert('creation successful!');
        window.location.href = 'admin.html'; //  Redirect
      } else {
        const errorText = await response.text();
        alert('creation failed: ' + errorText);
      }
    } catch (error) {
      console.error('Error:', error);
      alert('Could not connect to server.');
    }
  });
});
