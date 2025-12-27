
const btn = document.getElementById("toggleBtn");
    const content = document.getElementById("aboutContent");
    const fade = document.getElementById("fade");

    const COLLAPSED_HEIGHT = 180;
    let isExpanded = false;
    content.style.maxHeight = COLLAPSED_HEIGHT + "px";

    function updateFade() {
        fade.classList.toggle("hidden", isExpanded);
    }

    btn.addEventListener("click", () => {
        if (!isExpanded) {
            content.style.maxHeight = content.scrollHeight + "px";
            btn.classList.add("collapse");
            btn.innerHTML =
                '<span class="icon">Thu gọn <i class="fa-solid fa-angles-up"></i></span>';
        } else {
            content.style.maxHeight = COLLAPSED_HEIGHT + "px";
            btn.classList.remove("collapse");
            btn.innerHTML =
                '<span class="icon">Xem thêm <i class="fa-solid fa-angles-down"></i></span>';
        }

        isExpanded = !isExpanded;
        updateFade();
    });

    window.addEventListener("load", () => {
        if (content.scrollHeight <= COLLAPSED_HEIGHT) {
            btn.style.display = "none";
            fade.style.display = "none";
            content.style.maxHeight = "none";
        }
    });