document.querySelectorAll(".slider").forEach(slider => {
    const products = [...slider.children];
    const section = slider.closest(".product-section");
    const next = section.querySelector(".next");
    const prev = section.querySelector(".prev");

    const visibleItems = 5;
    const totalPages = Math.ceil(products.length / visibleItems);
    let pageIndex = 0;

    slider.innerHTML = "";
    const groups = [];

    for (let i = 0; i < totalPages; i++) {
        const group = document.createElement("div");
        group.className = "slide-group";

        products
            .slice(i * visibleItems, (i + 1) * visibleItems)
            .forEach(p => group.appendChild(p));

        slider.appendChild(group);
        groups.push(group);
    }

    groups[0].classList.add("active");

    function showPage(index){
        groups.forEach(g => g.classList.remove("active"));
        groups[index].classList.add("active");
    }

    next.onclick = () => {
        pageIndex = (pageIndex + 1) % totalPages;
        showPage(pageIndex);
    };

    prev.onclick = () => {
        pageIndex = (pageIndex - 1 + totalPages) % totalPages;
        showPage(pageIndex);
    };
});
