// Darken background color on hover
const sections = document.querySelectorAll('.section');

sections.forEach(section => {
  section.addEventListener('mouseenter', () => {
    section.style.backgroundColor = 'rgba(0, 0, 0, 0.9)';
  });
  
  section.addEventListener('mouseleave', () => {
    section.style.backgroundColor = 'rgba(0, 0, 0, 0.7)';
  });
});
