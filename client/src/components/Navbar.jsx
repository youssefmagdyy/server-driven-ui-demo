import "../styles/Navbar.css";

const Navbar = ({ children }) => {
  return (
    <nav className="navbar">
      <div className="navbar-inner">
        <div className="nav-links">{children}</div>
      </div>
    </nav>
  );
};

export default Navbar;
