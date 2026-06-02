document.addEventListener("DOMContentLoaded", function () {
    if (window.flatpickr) {
        flatpickr(".datepicker", {
            dateFormat: "Y-m-d",
            locale: "es",
            allowInput: true
        });
    }
});
