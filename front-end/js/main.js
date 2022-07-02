AOS.init({
	duration: 800,
	easing: 'slide'
});

(function ($) {

	"use strict";

	const baseUrl = "http://localhost:8080/api/v1"
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
	var queries = {};
	$.each(document.location.search.substr(1).split('&'), function (c, q) {
		var i = q.split('=');
		if (i[0])
			queries[i[0].toString()] = i[1].toString();
	});

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
	function popUp(res) {
		$("#myModal").find(".modal-title").empty()
		$("#myModal").find(".modal-body").empty()
		if (res === "Saved") {
			$("#myModal").find(".modal-title").append(`<h5 class="text-success">Success!</h5>`)
			$("#myModal").find(".modal-body").append(res)
		} else {
			$("#myModal").find(".modal-title").append(`<h5 class="text-danger">Error!</h5>`)
			$("#myModal").find(".modal-body").append(res)
		}
		$("#myModal").modal("show");
	}
	var addAdmin = $('#addAdmin')

	if (addAdmin != null) {

		addAdmin.on("submit", function (e) {
			e.preventDefault()
			const formData = formToObj(e.target)

			$.ajax({
				type: "POST",
				url: baseUrl + "/admin/save",
				data: JSON.stringify(formData),
				success: function (response) {
					popUp(response)
					if (response === "Saved") {
						$("#addAdmin")[0].reset();
						getAllData(baseUrl + "/admin/", ".admin-table", ["user_id", "first_name", "last_name", "email"])
					}
				},
				error: function ($xhr, textStatus, errorThrown) {
					let userData = JSON.parse(JSON.stringify($xhr.responseJSON))
					// console.log("ERROR : ",  userData.message);
					var mes = $("#modal-body");
					mes.empty();
					mes.append("Error : ", userData.error, "  ", "Status: ", userData.status);
					$("#myModal").modal("show");
					$("#addCar")[0].reset();
				},
				// dataType : "json",
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
			if (typeof $('#fileinput')[0].files[0] == "undefined") {
				popUp("Select image and fill the input values")
				return
			}
			form.append("file", $('#fileinput')[0].files[0], $('#fileinput')[0].files[0].name);
			form.append("car",
				new Blob([JSON.stringify(formData.car)], {
					type: 'application/json'
				})
			);

			var settings = {
				"url": baseUrl + "/car/save/1/",
				"method": "POST",
				"timeout": 0,
				"processData": false,
				"mimeType": "multipart/form-data",
				"contentType": false,
				"data": form
			};

			$.ajax(settings).done(function (response) {
				popUp(response)
				if (response === "Saved") {
					$("#addCar")[0].reset();
					getAllData(baseUrl + "/car", ".car-table", ["car_id", "brand", "model", "color"])
				}
			});
		})
	}
	var addCustomer = $('#addCustomer')
	if (addCustomer != null) {
		addCustomer.on("submit", function (e) {
			e.preventDefault()
			const formData = formToObj(e.target)
			$.ajax({
				type: "POST",
				url: baseUrl + "/customer/save",
				data: JSON.stringify(formData),
				success: function (result) {
					popUp(result)
					if (response === "Saved") {
						$("#addCustomer")[0].reset();
						getAllData(baseUrl + "/customer/", ".customer-table", ["customer_id", "address", "driver_licence"])
					}
				},
				error: function ($xhr, textStatus, errorThrown) {
					let userData = JSON.parse(JSON.stringify($xhr.responseJSON))
					// console.log("ERROR : ",  userData.message);
					var mes = $("#modal-body");
					mes.empty();
					mes.append("Error : ", userData.error, "  ", "Status: ", userData.status);
					$("#myModal").modal("show");
					$("#addCar")[0].reset();
				},
				contentType: "application/json; charset=utf-8"
			});
		})
	}

	var loginButton = $('a[href="login.html"]')
	if (loginButton != null && localStorage.getItem("role") != null) {
		loginButton.text("Logout")
		loginButton.click(function () {
			localStorage.removeItem("role")
			window.location.assign("/")
			return false;
		})
	}
	var login = $('#login')
	if (login != null) {

		login.on("submit", function (e) {
			e.preventDefault()
			const formData = formToObj(e.target)

			$.ajax({
				type: "POST",
				url: baseUrl + "/login",
				data: JSON.stringify(formData),
				success: function (response) {
					popUp(response)
					if (response === "Customer") {
						localStorage.setItem("role", "Customer")
						window.location.assign('/')
					} else if (response === "Admin") {
						localStorage.setItem("role", "Admin")
						window.location.assign('/admin.html')
					}
				},
				error: function ($xhr, textStatus, errorThrown) {
					let userData = JSON.parse(JSON.stringify($xhr.responseJSON))
					// console.log("ERROR : ",  userData.message);
					var mes = $("#modal-body");
					mes.empty();
					mes.append("Error : ", userData.error, "  ", "Status: ", userData.status);
					$("#myModal").modal("show");
					$("#login")[0].reset();
				},
				// dataType : "json",
				contentType: "application/json; charset=utf-8"
			});
		})
	}

	var register = $('#register')
	if (register != null) {

		register.on("submit", function (e) {
			e.preventDefault()
			const formData = formToObj(e.target)

			$.ajax({
				type: "POST",
				url: baseUrl + "/customer/save",
				data: JSON.stringify(formData),
				success: function (response) {
					popUp(response)
					window.location.assign('/login.html')
				},
				error: function ($xhr, textStatus, errorThrown) {
					let userData = JSON.parse(JSON.stringify($xhr.responseJSON))
					// console.log("ERROR : ",  userData.message);
					var mes = $("#modal-body");
					mes.empty();
					mes.append("Error : ", userData.error, "  ", "Status: ", userData.status);
					$("#myModal").modal("show");
					$("#login")[0].reset();
				},
				// dataType : "json",
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
	function getAllData(url, table, attrs) {
		$.ajax({
			type: "GET",
			url,
			success: function (result) {
				tableBuilder(table, result, attrs)
				if ($(table) != null && $(table).DataTable != undefined) {
					$(table).DataTable();
				}
			},
			contentType: "application/json; charset=utf-8"
		});
	}
	getAllData(baseUrl + "/admin/", ".admin-table", ["user_id", "first_name", "last_name", "email"])
	getAllData(baseUrl + "/customer/", ".customer-table", ["customer_id", "address", "driver_licence"])
	getAllData(baseUrl + "/car", ".car-table", ["car_id", "brand", "model", "color"])


	var carDetails = $("ftco-car-details")
	if (carDetails != null) {
		$.ajax({
			type: "GET",
			url: baseUrl + "/car/" + queries.id,
			success: function (result) {
				const mainDetails = $(".car-details")
				if (mainDetails != null) {
					mainDetails.find("div.img.rounded").css('background-image', 'url(/Upload/' + result.image1 + ')')
					mainDetails.find(".text .subheading").text(result.brand)
					mainDetails.find(".text h2").text(result.model)
					$("#mileage").text(result.mileage)
					$("#max_capacity").text(result.max_capacity)
					$("#max_bag_allow").text(result.max_bag_allow)
					$("#last_service_date").text(result.last_service_date || "Not shown")
					$("#year").text(result.year || "Not shown")
					$("#price_per_day").text(result.price_per_day + "$")
				}
			}
		})
	}

	const paginationWrapper = $(".block-27")
	if (paginationWrapper != null) {
		const paginationList = paginationWrapper.find("ul")
		paginationList.empty()
		$.ajax({
			type: "GET",
			url: baseUrl + "/car",
			success: function (result) {
				if (Array.isArray(result)) {
					// $(".cars-list").empty()
					if (queries.page) {
						const from = (queries.page - 1) * 6
						const to = from + 6
						$.each(result.slice(from, to), function (index) {
							const element = result[index]

							if (!element.is_rent)
								$(".cars-list").append(`<div class="col-md-4">
							<div class="car-wrap rounded ftco-animate">
								<div class="img rounded d-flex align-items-end"
									style="background-image: url(http://localhost:8080/Upload/${element.image1});">
								</div>
								<div class="text">
									<h2 class="mb-0"><a href="car-single.html">${element.model}</a></h2>
									<div class="d-flex mb-3">
										<span class="cat">${element.brand}</span>
										<p class="price ml-auto">$${element.price_per_day} <span>/day</span></p>
									</div>
									<p class="d-flex mb-0 d-block"><a href="#" class="btn btn-primary py-2 mr-1">Book now</a> <a
											href="car-single.html?id=${element.car_id}" class="btn btn-secondary py-2 ml-1">Details</a></p>
								</div>
							</div>
						</div>`)
						})
					} else {
						$.each(result.slice(0, 7), function (index) {
							const element = result[index]

							if (!element.is_rent)
							$(".cars-list").append(`<div class="col-md-4">
							<div class="car-wrap rounded ftco-animate">
								<div class="img rounded d-flex align-items-end"
									style="background-image: url(http://localhost:8080/Upload/${element.image1});">
								</div>
								<div class="text">
									<h2 class="mb-0"><a href="car-single.html">${element.model}</a></h2>
									<div class="d-flex mb-3">
										<span class="cat">${element.brand}</span>
										<p class="price ml-auto">$${element.price_per_day} <span>/day</span></p>
									</div>
									<p class="d-flex mb-0 d-block"><a href="#" class="btn btn-primary py-2 mr-1">Book now</a> <a
											href="car-single.html?id=${element.car_id}" class="btn btn-secondary py-2 ml-1">Details</a></p>
								</div>
							</div>
						</div>`)
						})
					}
					contentWayPoint();
					const pageSize = Math.round(result.length / 5)
					let navs = ""
					for (let index = 1; index <= pageSize; index++) {
						if (queries.page && queries.page == index) {
							navs += `<li class="active"><span>${index}</span></li>`
						}
						else {
							navs += `<li><a href="?page=${index}">${index}</a></li>`
						}
					}
					paginationList.append(navs)
					paginationList.append(`<li><a href="#">&gt;</a></li>`)
					paginationList.prepend(`<li><a href="#">&lt;</a></li>`)
				}
			},
			contentType: "application/json; charset=utf-8"
		});
	}
})(jQuery);

