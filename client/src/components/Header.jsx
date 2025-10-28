import "../styles/Header.css";

const Header = ({ title, subtitle }) => (
  <header className="header">
    <div className="header-content">
      <h1>{title}</h1>
      <p>{subtitle}</p>
    </div>
  </header>
);

export default Header;
