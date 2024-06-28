import NavbarNav from "./NavbarNav.jsx";

export default function Navbar() {
    return <>
        <nav className="navbar navbar-expand-lg">
            <a className="navbar-brand gradient" href="#">Jetson</a>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div className="navbar-nav">
                    <NavbarNav />
                </div>
            </div>
        </nav>
    </>
}