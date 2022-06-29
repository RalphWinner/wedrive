AOS.init({
	duration: 800,
	easing: 'slide'
});

(function ($) {

	"use strict";

	var isMobile = {
		Android: function () {
			return navigator.userAgent.match(/Android/i);
		},
		BlackBerry: function () {
			return navigator.userAgent.match(/BlackBerry/i);
		},
		iOS: function () {
			return navigator.userAgent.match(/iPhone|iPad|iPod/i);
		},
		Opera: function () {
			return navigator.userAgent.match(/Opera Mini/i);
		},
		Windows: function () {
			return navigator.userAgent.match(/IEMobile/i);
		},
		any: function () {
			return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows());
		}
	};


	$(window).stellar({
		responsive: true,
		parallaxBackgrounds: true,
		parallaxElements: true,
		horizontalScrolling: false,
		hideDistantElements: false,
		scrollProperty: 'scroll'
	});


	var fullHeight = function () {

		$('.js-fullheight').css('height', $(window).height());
		$(window).resize(function () {
			$('.js-fullheight').css('height', $(window).height());
		});

	};
	fullHeight();

	// loader
	var loader = function () {
		setTimeout(function () {
			if ($('#ftco-loader').length > 0) {
				$('#ftco-loader').removeClass('show');
			}
		}, 1);
	};
	loader();

	// Scrollax
	$.Scrollax();

	var carousel = function () {
		$('.carousel-car').owlCarousel({
			center: true,
			loop: true,
			autoplay: true,
			items: 1,
			margin: 30,
			stagePadding: 0,
			nav: false,
			navText: ['<span class="ion-ios-arrow-back">', '<span class="ion-ios-arrow-forward">'],
			responsive: {
				0: {
					items: 1
				},
				600: {
					items: 2
				},
				1000: {
					items: 3
				}
			}
		});
		$('.carousel-testimony').owlCarousel({
			center: true,
			loop: true,
			items: 1,
			margin: 30,
			stagePadding: 0,
			nav: false,
			navText: ['<span class="ion-ios-arrow-back">', '<span class="ion-ios-arrow-forward">'],
			responsive: {
				0: {
					items: 1
				},
				600: {
					items: 2
				},
				1000: {
					items: 3
				}
			}
		});

	};
	carousel();

	$('nav .dropdown').hover(function () {
		var $this = $(this);
		// 	 timer;
		// clearTimeout(timer);
		$this.addClass('show');
		$this.find('> a').attr('aria-expanded', true);
		// $this.find('.dropdown-menu').addClass('animated-fast fadeInUp show');
		$this.find('.dropdown-menu').addClass('show');
	}, function () {
		var $this = $(this);
		// timer;
		// timer = setTimeout(function(){
		$this.removeClass('show');
		$this.find('> a').attr('aria-expanded', false);
		// $this.find('.dropdown-menu').removeClass('animated-fast fadeInUp show');
		$this.find('.dropdown-menu').removeClass('show');
		// }, 100);
	});


	$('#dropdown04').on('show.bs.dropdown', function () {
		console.log('show');
	});

	// scroll
	var scrollWindow = function () {
		$(window).scroll(function () {
			var $w = $(this),
				st = $w.scrollTop(),
				navbar = $('.ftco_navbar'),
				sd = $('.js-scroll-wrap');

			if (st > 150) {
				if (!navbar.hasClass('scrolled')) {
					navbar.addClass('scrolled');
				}
			}
			if (st < 150) {
				if (navbar.hasClass('scrolled')) {
					navbar.removeClass('scrolled sleep');
				}
			}
			if (st > 350) {
				if (!navbar.hasClass('awake')) {
					navbar.addClass('awake');
				}

				if (sd.length > 0) {
					sd.addClass('sleep');
				}
			}
			if (st < 350) {
				if (navbar.hasClass('awake')) {
					navbar.removeClass('awake');
					navbar.addClass('sleep');
				}
				if (sd.length > 0) {
					sd.removeClass('sleep');
				}
			}
		});
	};
	scrollWindow();

	var isMobile = {
		Android: function () {
			return navigator.userAgent.match(/Android/i);
		},
		BlackBerry: function () {
			return navigator.userAgent.match(/BlackBerry/i);
		},
		iOS: function () {
			return navigator.userAgent.match(/iPhone|iPad|iPod/i);
		},
		Opera: function () {
			return navigator.userAgent.match(/Opera Mini/i);
		},
		Windows: function () {
			return navigator.userAgent.match(/IEMobile/i);
		},
		any: function () {
			return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows());
		}
	};

	var counter = function () {

		$('#section-counter, .hero-wrap, .ftco-counter').waypoint(function (direction) {

			if (direction === 'down' && !$(this.element).hasClass('ftco-animated')) {

				var comma_separator_number_step = $.animateNumber.numberStepFactories.separator(',')
				$('.number').each(function () {
					var $this = $(this),
						num = $this.data('number');
					console.log(num);
					$this.animateNumber(
						{
							number: num,
							numberStep: comma_separator_number_step
						}, 7000
					);
				});

			}

		}, { offset: '95%' });

	}
	counter();


	var contentWayPoint = function () {
		var i = 0;
		$('.ftco-animate').waypoint(function (direction) {

			if (direction === 'down' && !$(this.element).hasClass('ftco-animated')) {

				i++;

				$(this.element).addClass('item-animate');
				setTimeout(function () {

					$('body .ftco-animate.item-animate').each(function (k) {
						var el = $(this);
						setTimeout(function () {
							var effect = el.data('animate-effect');
							if (effect === 'fadeIn') {
								el.addClass('fadeIn ftco-animated');
							} else if (effect === 'fadeInLeft') {
								el.addClass('fadeInLeft ftco-animated');
							} else if (effect === 'fadeInRight') {
								el.addClass('fadeInRight ftco-animated');
							} else {
								el.addClass('fadeInUp ftco-animated');
							}
							el.removeClass('item-animate');
						}, k * 50, 'easeInOutExpo');
					});

				}, 100);

			}

		}, { offset: '95%' });
	};
	contentWayPoint();


	// navigation
	var OnePageNav = function () {
		$(".smoothscroll[href^='#'], #ftco-nav ul li a[href^='#']").on('click', function (e) {
			e.preventDefault();

			var hash = this.hash,
				navToggler = $('.navbar-toggler');
			$('html, body').animate({
				scrollTop: $(hash).offset().top
			}, 700, 'easeInOutExpo', function () {
				window.location.hash = hash;
			});


			if (navToggler.is(':visible')) {
				navToggler.click();
			}
		});
		$('body').on('activate.bs.scrollspy', function () {
			console.log('nice');
		})
	};
	OnePageNav();


	// magnific popup
	$('.image-popup').magnificPopup({
		type: 'image',
		closeOnContentClick: true,
		closeBtnInside: false,
		fixedContentPos: true,
		mainClass: 'mfp-no-margins mfp-with-zoom', // class to remove default margin from left and right side
		gallery: {
			enabled: true,
			navigateByImgClick: true,
			preload: [0, 1] // Will preload 0 - before current, and 1 after the current image
		},
		image: {
			verticalFit: true
		},
		zoom: {
			enabled: true,
			duration: 300 // don't foget to change the duration also in CSS
		}
	});

	$('.popup-youtube, .popup-vimeo, .popup-gmaps').magnificPopup({
		disableOn: 700,
		type: 'iframe',
		mainClass: 'mfp-fade',
		removalDelay: 160,
		preloader: false,

		fixedContentPos: false
	});


	$('#book_pick_date,#book_off_date').datepicker({
		'format': 'm/d/yyyy',
		'autoclose': true
	});
	$('#time_pick').timepicker();
	var addAdmin = $('#addAdmin')
	if (addAdmin != null) {
		addAdmin.on("submit", function (e) {
			e.preventDefault()
			const formData = formToObj(e.target)
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/api/v1/admin/save",
				data: JSON.stringify(formData),
				success: function (result) {
					alert(result)
				},
				contentType: "application/json; charset=utf-8"
			});
		})
	}
	var addCar = $('#addCar')
	if (addCar != null) {
		addCar.on("submit", function (e) {
			e.preventDefault()
			const formData = formToObj(e.target)
			var form = new FormData();
			console.log($('#fileinput')[0].files[0])
			form.append("file", $('#fileinput')[0].files[0], $('#fileinput')[0].files[0].name);
			form.append("car",
				new Blob([JSON.stringify(formData.car)], {
					type: 'application/json'
				})
			);

			var settings = {
				"url": "http://localhost:8080/api/v1/car/save/1/",
				"method": "POST",
				"timeout": 0,
				"processData": false,
				"mimeType": "multipart/form-data",
				"contentType": false,
				"data": form
			};

			$.ajax(settings).done(function (response) {
				console.log(response);
			});
			// const formData = formToObj(e.target)
			// var form = new FormData();
			// console.log(new Blob([JSON.stringify(formData.car)], {
			// 	type: "application/json"
			// }))
			// form.append("car", new Blob([JSON.stringify(formData.car)], {
			// 	type: "application/json"
			// }))
			// form.append('file', $('#fileinput')[0].files[0]);
			// $.ajax({

			// 	url: "http://localhost:8080/api/v1/car/save/1",
			// 	data: form,
			// 	method: "POST",
			// 	timeout: 600000,
			// 	processData: false,
			// 	mimeType: "multipart/form-data",
			// 	contentType: false,
			// 	success: function (result) {
			// 		alert("Success!")
			// 	},
			// 	contentType: "application/json; charset=utf-8"
			// });
		})
	}
	var addCustomer = $('#addCustomer')
	if (addCustomer != null) {
		addCustomer.on("submit", function (e) {
			e.preventDefault()
			const formData = formToObj(e.target)
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/api/v1/customer/save",
				data: JSON.stringify(formData),
				success: function (result) {
					alert("Success!")
				},
				dataType: "json",
				contentType: "application/json; charset=utf-8"
			});
		})
	}


	function tableBuilder(table, data, attrs) {
		const tableWrapper = $(table)
		if (tableBuilder != null) {
			tableWrapper.find("tbody").empty()
			const header = tableWrapper.find("thead").find("tr")
			header.empty()
			for (let index = 0; index < attrs.length; index++) {
				const element = attrs[index];
				header.append(`<th>${element.toUpperCase()}</th>`)
			}
			for (let index = 0; index < data.length; index++) {
				const element = data[index];
				let row = ""
				for (const key in element) {
					if (Object.hasOwnProperty.call(element, key)) {
						const innerElement = element[key];
						if (attrs.includes(key)) {
							row += `<td>${innerElement || "Not given"}</td>`
						}
					}
				}
				tableWrapper.find("tbody").append(`
				<tr>
                    ${row}
				</tr>`)
			}
		}
	}
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/v1/admin/",
		success: function (result) {
			tableBuilder(".admin-table", result, ["user_id", "first_name", "last_name", "email"])
			$('.admin-table').DataTable();
		},
		contentType: "application/json; charset=utf-8"
	});
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/api/v1/customer/",
		success: function (result) {
			console.log(result)
			tableBuilder(".customer-table", result, ["customer_id", "address", "driver_licence"])
			$('.customer-table').DataTable();
		},
		contentType: "application/json; charset=utf-8"
	});


})(jQuery);

