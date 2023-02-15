const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});
(function() {
	"use strict"; // Start of use strict
  
	var mainNav = document.querySelector('#mainNav');
  
	if (mainNav) {
	  var collapseNavbar = function() {
  
		var scrollTop = (window.pageYOffset !== undefined) ? window.pageYOffset : (document.documentElement || document.body.parentNode || document.body).scrollTop;
  
		if (scrollTop > 100) {
		  mainNav.classList.add("navbar-shrink");
		} else {
		  mainNav.classList.remove("navbar-shrink");
		}
	  };
	  collapseNavbar();
	  document.addEventListener("scroll", collapseNavbar);
	}
  
  })();